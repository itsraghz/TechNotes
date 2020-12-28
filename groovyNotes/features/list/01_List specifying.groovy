List myList = [1, 2, 3]
assert myList.size() == 3
assert myList[0] == 1
assert myList instanceof ArrayList
List emptyList = []
assert emptyList.size() == 0
List longList = (0..1000).toList()
assert longList[555] == 555

List explicitList = new ArrayList()
explicitList.addAll(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10
explicitList = new LinkedList(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10