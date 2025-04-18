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
;

-- 初期設定
INSERT INTO public.setting(
	setting_group, setting_key, setting_value, setting_description, created_by, created_at)
	VALUES ('todo','limit','30','ToDo一覧の登録上限', 'SYSTEM', CURRENT_TIMESTAMP);