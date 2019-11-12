package com.swag.apps.kc

class NumberHolder {

    private fun isNum(c: Char) : Boolean {
        return (c - '0') >= 0 && (c - '0') <= 9
    }

    fun evaluate(query: String) : Long {
        println("Provided query : $query")
        val chars = query.toCharArray()
        var operator =  ' '
        var result: Long = 0
        var num: Long = 0
        for (c in chars) {
            if (isNum(c)) {
                println("Converted value : " + (c - '0'))
                num = num*10 + (c - '0')
            } else {
                println("Found operator : $operator, num : $num, result : $result")
                if (operator != ' ') {
                    // Perform
                    when(operator) {
                        '+' -> result += num
                        '-' -> result -= num
                        '*' -> result *= num
                        '/' -> result /= num
                    }
                } else {
                    // First time
                    result = num
                }
                operator = c
                num = 0
            }
        }

        println("Found operator : $operator, num : $num, result : $result")
        // Last number
        if (num != 0L) {
            // Perform
            when(operator) {
                '+' -> result += num
                '-' -> result -= num
                '*' -> result *= num
                '/' -> result /= num
                ' ' -> result = num
            }
        }

        return result
    }
}