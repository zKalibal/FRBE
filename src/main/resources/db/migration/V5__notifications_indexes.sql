
CREATE INDEX IF NOT EXISTS idx_notifications_user_seen
    ON fr_users_notifications(iduser, seen);
