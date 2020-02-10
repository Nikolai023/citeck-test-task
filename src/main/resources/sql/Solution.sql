SELECT existed.number + 1                       as start,
       min(nextNum.number) - existed.number - 1 as count
FROM numbers existed
         LEFT OUTER JOIN numbers empty
                         ON existed.number = empty.number - 1
         LEFT OUTER JOIN numbers nextNum
                         ON existed.number < nextNum.number
WHERE empty IS NULL
GROUP BY existed.number
ORDER BY start;