
-- Create the enum type
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'user_type') THEN
            CREATE TYPE user_type AS ENUM ('ADMIN', 'USER', 'MANAGER');
        END IF;
    END $$;

-- Create temporary column with new type
ALTER TABLE users ADD COLUMN type_new user_type;

-- Update the new column with converted values
UPDATE users SET type_new =
                     CASE
                         WHEN UPPER(type::text) = 'ADMIN' THEN 'ADMIN'::user_type
                         WHEN UPPER(type::text) = 'USER' THEN 'USER'::user_type
                         WHEN UPPER(type::text) = 'MANAGER' THEN 'MANAGER'::user_type
                         ELSE 'USER'::user_type
                         END;

-- Drop the old column and rename the new one
ALTER TABLE users DROP COLUMN type;
ALTER TABLE users RENAME COLUMN type_new TO type;

-- Set default value for new column
ALTER TABLE users ALTER COLUMN type SET DEFAULT 'ADMIN'::user_type;