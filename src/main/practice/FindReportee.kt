package practice

/**
 * You have an Employee class
 * class Employee{ String name; Integer id, Employee manager }
 * Each employee has a manager and the manager of CEO is null.
 * Find all direct and indirect reportees of a manager.
 * Eg. Say Employee e1 reports to CEO, e2 and e3 reports to e1,
 * e4 and e5 reports to e2, e6 reports to e3.
 * Then by giving e1 as input, output should be e2, e3, e4, e5 and e6.
 *
 *
 */

data class Employee(val name: String, val id: Int, val manager: Employee?)

fun main(args: Array<String>) {
    val ceo = Employee("CEO", 1, null)
    val emp1 = Employee("e1", 2, ceo)
    val emp2 = Employee("e2", 3, emp1)
    val emp3 = Employee("e3", 4, emp1)
    val emp4 = Employee("e4", 5, emp2)
    val emp5 = Employee("e5", 6, emp2)
    val emp6 = Employee("e6", 7, emp3)
    val employees = arrayListOf(ceo, emp1, emp2, emp3, emp4, emp5, emp6)
    println(findReportees(employees, emp1))

}

fun findReportees(employees: List<Employee>, employee: Employee): String {
    val directReportees = employees.filter { it.manager?.id == employee.id }
    val indirectReportees = mutableListOf<Employee>()
    directReportees.forEach { e ->
        employees.filter { it.manager?.id == e.id }.forEach {
            indirectReportees.add(it)
        }
    }
    val combined = directReportees.union(indirectReportees).map { it.name }
    return combined.toString()
}

