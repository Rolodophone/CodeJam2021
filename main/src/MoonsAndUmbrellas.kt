fun main() {
	val tests = readLine()!!.toInt()

	for (caseNo in 1..tests) {
		val inputs = readLine()!!.split(" ")
		val cJCost = inputs[0].toInt()
		val jCCost = inputs[1].toInt()
		val string = inputs[2]

		debug { "X=$cJCost Y=$jCCost string=$string" }

		println("Case #$caseNo: ${moonsUmbrellas(cJCost, jCCost, string)}")
	}
}

fun moonsUmbrellas(cJCost: Int, jCCost: Int, string: String): Int {
	val cToC = Regex("""C\?+C""").findAll(string).count()
	val cToJ = Regex("""C\?+J""").findAll(string).count()
	val jToC = Regex("""J\?+C""").findAll(string).count()
	val jToJ = Regex("""J\?+J""").findAll(string).count()
	val startJ = Regex("""^\?+J""").findAll(string).count()
	val jEnd = Regex("""J\?+$""").findAll(string).count()
	val startC = Regex("""^\?+C""").findAll(string).count()
	val cEnd = Regex("""C\?+$""").findAll(string).count()
	val cj = Regex("""CJ""").findAll(string).count()
	val jc = Regex("""JC""").findAll(string).count()

	debug { "cToC:$cToC cToJ:$cToJ jToC:$jToC jToJ:$jToJ startJ:$startJ jEnd:$jEnd startC:$startC cEnd:$cEnd cj:$cj jc:$jc" }

	return cJCost * (cToJ + cj) + jCCost * (jToC + jc)
}