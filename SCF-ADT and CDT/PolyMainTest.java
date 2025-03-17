import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PolyMainTest {
    @Test
    void evaluateTest(){
        Term[] terms = {new Term(2,2) , new Term(3,1) , new Term(1,0)};
        Poly input1 = new Poly(terms);
        assertEquals(15f, input1.evaluate(2f) , 0.0001f);

        Term[] terms2 = {new Term(4,3) , new Term(2,0)};
        Poly input2 = new Poly(terms2);
        assertEquals(-2f, input2.evaluate(-1f) , 0.0001f);
    }

    @Test
    void getDegreeTest(){
        Term[] terms = {new Term(2,2) , new Term(3,1) , new Term(1,0)};
        Poly input1 = new Poly(terms);
        assertEquals(2, input1.getDegree());

        Term[] terms2 = {new Term(4,3) , new Term(2,0)};
        Poly input2 = new Poly(terms2);
        assertEquals(3, input2.getDegree());
    }

    @Test
    void addPolyTest(){
        Term[] term1Set1 = {new Term(2,2) , new Term(3,1), new Term(1,0)};
        Poly input1Set1 = new Poly(term1Set1);
        Term[] term2Set1 = {new Term(3,2) , new Term(4,0)};
        Poly input2Set1 = new Poly(term2Set1);

        Poly actualResultSet1 = Poly.addPoly(input1Set1 , input2Set1);
        Term[] actualResultTerms = actualResultSet1.getTerms();

        assertEquals(3, actualResultTerms.length);
        
        verifyTerm(actualResultTerms[0], 5, 2);
        verifyTerm(actualResultTerms[1], 3, 1);
        verifyTerm(actualResultTerms[2], 5, 0);        
    }

    @Test
    void multiplyPolyTest(){
        Term[] term1Set1 = {new Term(2,2) , new Term(3,1), new Term(1,0)};
        Poly input1Set1 = new Poly(term1Set1);
        Term[] term2Set1 = {new Term(3,2) , new Term(4,0)};
        Poly input2Set1 = new Poly(term2Set1);

        Poly actualResultSet1 = Poly.multiplyPoly(input1Set1 , input2Set1);
        Term[] actualResultTerms = actualResultSet1.getTerms();

        verifyTerm(actualResultTerms[0], 4, 0);
        verifyTerm(actualResultTerms[1], 12, 1);
        verifyTerm(actualResultTerms[2], 11, 2);
        verifyTerm(actualResultTerms[3], 9, 3);
        verifyTerm(actualResultTerms[4], 6, 4);
    }

    //Helper funtion to verify terms while adding and multiplying polynomials
    void verifyTerm(Term term , int coefficient , int exponent){
        assertEquals(coefficient, term.getCoefficient());
        assertEquals(exponent, term.getExponent());
    }
    
}
