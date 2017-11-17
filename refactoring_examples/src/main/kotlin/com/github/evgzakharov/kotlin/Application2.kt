package com.github.evgzakharov.kotlin

fun main(args: Array<String>) {
    /*
    String text = "First Line\n" +
              "Second Line\n" +
              "Third Line";
     */

    val text = """
        |First Line
        |Second Line
        |Third Line
    """.trimMargin()

    val text2 = """
        SELECT
                realm,
                payment_gateway,
                payment_method,
                "user",
                "order",
                external_transaction_id,
                payment_datetime,
                transaction_type,
                amount,
                fee,
                tax,
                net_amount,
                currency,
                user_amount,
                user_fee,
                user_exchange_rate,
                user_net_amount,
                user_currency,
                user_tax,
                settlement_currency,
                settlement_tax,
                user_country,
                payment_country,
                is_vat_paid,
                payment_method_variant
        FROM AAH_TRANSACTIONS_WG_VIEW
    """.trimIndent()

    println(text)

    println(text2)
}