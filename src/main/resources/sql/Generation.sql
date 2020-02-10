DROP TABLE numbers;

CREATE TABLE numbers
(
    number INTEGER PRIMARY KEY
);

DO
$$
    DECLARE
        i INTEGER := 0;
    BEGIN
        WHILE (i < 100)
            LOOP
                if (random() > 0.5) THEN
                    INSERT INTO numbers (number) VALUES (i);
                END IF;
                i := i + 1;
            END LOOP;
    END;
$$
LANGUAGE plpgsql;