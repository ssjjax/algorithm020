学习笔记

public void recur(int level, int param) {
	// terminator
	if (level > MAX_LEVEL) {
		// process result
		return;
	}

   // process current logic
	process(level, param);

  // drill down
	recur( level: level + 1, newParam);
	// restore current status
}


def divide_conquer(problem, param1, param2, ...):
# recursion terminator 一般到叶就结束了
if problem is None:
	print_result
	return
# prepare data 处理当期逻辑层
data = prepare_data(problem)
subproblems = split_problem(problem, data)
# conquer subproblems 如何拆分成子问题是重点
subresult1 = self.divide_conquer(subproblems[0], p1, ...)
subresult2 = self.divide_conquer(subproblems[1], p1, ...)
subresult3 = self.divide_conquer(subproblems[2], p1, ...)
...
# process and generate the final result 组合成最终结果（比递归多的部分）
result = process_result(subresult1, subresult2, subresult3, …)
# revert the current level states