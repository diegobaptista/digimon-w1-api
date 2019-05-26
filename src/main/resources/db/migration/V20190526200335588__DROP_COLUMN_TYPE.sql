ALTER TABLE digidex
DROP COLUMN "type";

ALTER TABLE digidex
ADD COLUMN active_period VARCHAR(50);