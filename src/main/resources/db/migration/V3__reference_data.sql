
-- Seed platforms
INSERT INTO fr_platforms(id,name,slug,priority) VALUES
 (1,'PC','pc',1),
 (2,'PlayStation 5','ps5',2),
 (3,'Xbox Series X|S','xbox-series',3),
 (4,'Nintendo Switch','switch',4)
ON CONFLICT DO NOTHING;

-- Seed rubrics (sample)
INSERT INTO fr_rubrics(id,name,description) VALUES
 (1,'Rubrica Test','Rubrica di esempio')
ON CONFLICT DO NOTHING;
