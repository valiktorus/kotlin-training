package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            dayOfMonth != other.dayOfMonth -> dayOfMonth - other.dayOfMonth
            else -> 0
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

operator fun MyDate.plus(multiInterval: MultiInterval): MyDate = addTimeIntervals(multiInterval.interval, multiInterval.number)

data class MultiInterval(val interval: TimeInterval, val number: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
operator fun TimeInterval.times(number: Int): MultiInterval = MultiInterval(this, number)


class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate>{
            var current = start
            override fun hasNext(): Boolean = current <= endInclusive

            override fun next(): MyDate  = current.apply{
                current = nextDay()
            }
        }
    }
}

