-- Birthday table for storing birthday information
-- user_id has no FK constraint yet (will be added when users table is created)

CREATE TABLE birthdays (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    person_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    notes TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);
