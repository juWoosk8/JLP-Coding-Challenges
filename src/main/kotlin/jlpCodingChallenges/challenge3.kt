package jlpCodingChallenges

fun processSokobanMove(squareArray: Array<String>, move: String): Array<String> {
    val row = squareArray.size
    val column = squareArray[0].length
    val nestedArray = Array(row) { CharArray(column) }
    for (i in 0 until row) {
        for (j in 0 until column) {
            nestedArray[i][j] = squareArray[i].toCharArray()[j]
        }
    }
    when (move) {
        "L" -> move(nestedArray, -1, 0)
        "R" -> move(nestedArray, 1, 0)
        "D" -> move(nestedArray, 0, 1)
        "U" -> move(nestedArray, 0, -1)
    }
    for (i in 0..squareArray.lastIndex) {
        squareArray[i] = nestedArray[i].joinToString("")
    }
    return squareArray
}

fun move(nestedArray: Array<CharArray>, x: Int, y: Int): Array<CharArray> {
    outerloop@ for (i in 0..nestedArray.lastIndex) {
        loop@ for (j in nestedArray[0].indices) {
            if (nestedArray[i][j].toUpperCase() == 'P') {
                when (nestedArray[i + y][j + x]) {
                    '#' -> {if (x>0) break@loop
                        if (y>0) break@outerloop}
                    ' ' -> {
                        println("here" + (i + y).toString() + " " + (j + x))
                        nestedArray[i + y][j + x] = 'p'
                        nestedArray[i][j] = ' '
                        if (x>0) break@loop
                        if (y>0) break@outerloop
                    }
                    '*' -> {
                        nestedArray[i + y][j + x] = 'P'
                        nestedArray[i][j] = ' '
                        if (x>0) break@loop
                        if (y>0) break@outerloop
                    }
                    'b' -> {
                        when (nestedArray[i + y * 2][j + x * 2]) {
                            '#', 'b' -> {
                                if (x>0) break@loop
                                if (y>0) break@outerloop
                            }
                            ' ' -> {
                                nestedArray[i + y * 2][j + x * 2] = 'b'
                                nestedArray[i + y][j + x] = 'p'
                                nestedArray[i][j] = ' '
                                if (x>0) break@loop
                                if (y>0) break@outerloop
                            }
                            '*' -> {
                                nestedArray[i + y * 2][j + x * 2] = 'B'
                                nestedArray[i + y][j + x] = 'p'
                                nestedArray[i][j] = ' '
                                if (x>0) break@loop
                                if (y>0) break@outerloop
                            }
                        }
                    }
                }
            }
        }
    }
    return nestedArray
}
