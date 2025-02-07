package calculator

import spock.lang.Specification

class CalculatorSpec extends Specification {
    def "Addition should return the correct sum"() {
        expect:
        2 + 3 == 5
    }
}