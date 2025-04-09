-- ユーザマスタの作成
DROP TABLE IF EXISTS account
;

CREATE TABLE account (
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