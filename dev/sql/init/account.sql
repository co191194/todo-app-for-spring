-- ユーザマスタの作成

CREATE TABLE IF NOT EXISTS account (
    user_id VARCHAR(20) CONSTRAINT pkey_account PRIMARY KEY,
    user_pw VARCHAR(100) NOT NULL,
    user_name VARCHAR(30),
    is_locked BOOLEAN NOT NULL DEFAULT (FALSE),
    count_try INTEGER NOT NULL DEFAULT (0),
    version INTEGER NOT NULL DEFAULT (1),
    created_by VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_by VARCHAR(20),
    updated_at TIMESTAMP
)
;

-- テスト用のユーザ
INSERT INTO
    account (user_id, user_pw, user_name, created_by, created_at)
VALUES
    ('test2', '$2b$12$jgN3M4fuP2T8xeous3uTbumFkooq4mFBYsWVeEG63S6iZsnBIDjCG', 'テスト１', 'SYSTEM', CURRENT_TIMESTAMP);
