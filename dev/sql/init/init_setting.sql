INSERT INTO public.setting(
	setting_group, setting_key, setting_value, setting_description, created_by, created_at)
	VALUES ('todo','limit','30','ToDo一覧の登録上限', 'SYSTEM', CURRENT_TIMESTAMP);