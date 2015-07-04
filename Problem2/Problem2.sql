/**
* Problem2
*
* @Xin He
* 07/03/2015
* 
*/

select PRODUCT_ID "Product ID", sum(total) "Total Sales"
from
    (
        (
        select PRODUCT_ID, total
        from
            /* This part of the query return one column of all the records fulfill the firsr requirement */
            /* Set this as "temp1"*/
            (
            select PRODUCT.PRODUCT_ID
            from ORDER_ITEM natural join ORDER_HEADER natural join PRODUCT
            where QUANTITY >= 1000 
             	and ORDER_DATE between '2014-01-01 00:00:00' and '2014-12-31 23:59:59'
            group by PRODUCT.PRODUCT_ID
            ) 
            as temp1,

            /* This part of the query return 3 columns of all the records fulfill the firsr requirement*/
            /* Set this as "temp2"*/
            (
            select sum(UNIT_PRICE * QUANTITY) total, DISCONTINUE_DATE, REPLACEMENT_PRODUCT_ID
            from ORDER_ITEM natural join ORDER_HEADER natural join PRODUCT
            where QUANTITY >= 1000 
                and ORDER_DATE between '2014-01-01 00:00:00' and '2014-12-31 23:59:59'
            group by PRODUCT.PRODUCT_ID
            )
            as temp2
     
        where temp1.PRODUCT_ID = temp2.REPLACEMENT_PRODUCT_ID
        )
        /* 
        * By using the where clause we actually form a 4 columns table 
        * and change the first column to the REPLACEMENT_PRODUCT_ID with all the discontinues products
        */
    
	union 
        /* Then we union with the table with no discontinued products */
        (
        select PRODUCT.PRODUCT_ID , sum(UNIT_PRICE * QUANTITY) total
        from ORDER_ITEM natural join ORDER_HEADER natural join PRODUCT
        where QUANTITY >= 1000 
            and ORDER_DATE between '2014-01-01 00:00:00' and '2014-12-31 23:59:59' 
    		and DISCONTINUE_DATE is null
        group by PRODUCT.PRODUCT_ID
        )
    )
    as temp3
group by PRODUCT_ID