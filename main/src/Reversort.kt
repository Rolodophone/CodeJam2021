fun main() {
	val tests = readLine()!!.toInt()

	for (caseNo in 1..tests) {
		val listLen = readLine()!!.toInt()
		val list = readLine()!!.split(" ").map { it.toInt() }

		debug { "listLen=$listLen, list=$list" }

		println("Case #$caseNo: ${reversort(list.toMutableList())}")
	}
}

fun reversort(list: MutableList<Int>): Int {
	var cost = 0

	for (i in 0 until list.size - 1) {
		var min = Int.MAX_VALUE
		var j = 0

		for (index in i until list.size) {
			val value = list[index]
			if (value < min) {
				j = index
				min = value
			}
		}

		//swap
		for (index in i..(i+j)/2) {
			val otherIndex = j - index + i
			val temp = list[index]
			list[index] = list[otherIndex]
			list[otherIndex] = temp
		}

		cost += j - i + 1

		debug { "i=$i, j=$j, cost=${j - i + 1}, list=$list" }
	}

	return cost
}