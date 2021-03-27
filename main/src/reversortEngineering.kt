fun main() {
	val tests = readLine()!!.toInt()

	for (caseNo in 1..tests) {
		val input = readLine()!!.split(" ").map { it.toInt() }

		debug { "desiredSize=${input[0]} desiredCost=${input[1]}" }

		val list = reversortEngineering(input[0], input[1])
		val output = list?.joinToString(" ") ?: "IMPOSSIBLE"

		println("Case #$caseNo: $output")
	}
}

fun reversortEngineering(desiredSize: Int, desiredCost: Int): List<Int>? {
	if (desiredCost < desiredSize - 1) return null

	val permutations = permute((1..desiredSize).toList())

	for (perm in permutations) {
		if (reversort(perm.toMutableList()) == desiredCost) {
			return perm
		}
	}

	return null
}

fun permute(nums: List<Int>): List<List<Int>> {
	var permList = listOf(listOf(nums.first()))

	for (num in nums.slice(1 until nums.size)) {
		val newList = mutableListOf<List<Int>>()

		for (perm in permList) {
			for (i in 0..perm.size) {
				newList.add(perm.toMutableList().apply {
					add(i, num)
				})
			}
		}

		permList = newList
	}

	return permList
}