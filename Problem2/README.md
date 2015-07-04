Problem2: SQL query
========

The first requirement was very easy to achieve where no nested quieries are needed.
To get to the second requirement was hard.

The basic idea is, first trying to find out which product is discontinued and in the temporary intermidate table, change the PRODUCT_ID to its PREPLACEMENT_PRODUCT_ID. Then union this table with the table from first requirement. Then do a total "group by", we can get the final result.

So basically we first use temp1 and temp2 as temp tables in the middle to form a table like this:

| PRODUCT.PRODUCT_ID  | total | DISCONTINUE_DATE | REPLACEMENT_PRODUCT_ID |
| ------------------- | ----- | ---------------- | ---------------------- |
|           5         |   50  | xxxx-xx-xx xx:xx |            5           |
|          25         |  530  | xxxx-xx-xx xx:xx |           25           |
|          40         |  300  | xxxx-xx-xx xx:xx |           40           |

Basically is substitute the first column, let it equal to the last column "REPLACEMENT_PRODUCT_ID".

Then find out the other non-discontinued products and union them.

Since the discontinued products' PRODUCT_ID have been changed to their heritance PRODUCT_ID, we can group by them easily.