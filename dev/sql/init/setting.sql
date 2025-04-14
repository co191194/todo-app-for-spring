-- 設定マスタ
CREATE TABLE IF NOT EXISTS setting (
    setting_group VARCHAR(30) NOT NULL,
    setting_key VARCHAR(30) NOT NULL,
    setting_value VARCHAR(100) NOT NULL,
    setting_description VARCHAR(100) NOT NULL,
    version integer NOT NULL DEFAULT(1),
    created_by VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_by VARCHAR(20),
    updated_at TIMESTAMP,
    CONSTRAINT pk_setting PRIMARY KEY (setting_group, setting_key)
)