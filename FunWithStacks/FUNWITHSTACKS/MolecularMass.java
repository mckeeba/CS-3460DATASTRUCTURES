



import java.util.Scanner;

public class MolecularMass {

    public static void main(String[] args) {

        MolecularMass m = new MolecularMass();
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the molecule: ");

        String atomFormula = userInput.nextLine();

        int totalWeight = m.molecularMass(atomFormula);
        System.out.println("The molecular mass of " + atomFormula + " is " + totalWeight);
        userInput.close();

        
    }

    /**
     * method to process user's input into the IntStack
     * step 0- instantiate 'H' as 1, 'C' as 12,'O' as 16, and '(' as 0. Note: these
     * values are going to be in a string, we need to pull them out as characters
     * and set them as integer values.
     * step1- cycle through the user's input formula and convert to integer values
     * *Loop
     * step 2- push and pop then calcuate weight
     */

    public int molecularMass(String atomFormula) {
        
        IntStack stack = new IntStack();
        int totalMass = 0;
        int weight = 0;
        for (char i : atomFormula.toCharArray()) {
            switch (i)

            {
                case ('('):
                    stack.push(0);
                    // weight = 0;
                    break;

                case ('C'):
                    stack.push(12);
                    // weight = 12;
                    break;

                case ('H'):
                    stack.push(1);
                    // weight = 1;
                    break;

                case ('O'):
                    stack.push(16);
                    // weight = 16;
                    break;

                case (')'):
                    weight = 0;
                    while (stack.peek() != 0) {
                        weight += stack.pop();

                    }
                    stack.push(weight);

                    // while stack is not empty and zero isn't on the top of the stack we will
                    // continue popping off till this no longer holds true

                    /*
                     * while(!stack.isEmpty()&& stack.peek()!= 0);
                     * {
                     * weight +=stack.pop();
                     * 
                     * }
                     * stack.push(weight);
                     */

                    break;

                // somehow need to implement a way to see a number in the character array, pop
                // off the stack, and multiply that number by what was popped off, then push
                // result on stack
                default:

                    int multiply = i - '0';
                    // int p = stack.pop();
                    // stack.pop();
                    int v = stack.pop();
                    weight = v * multiply;
                    stack.push(weight);

                    break;

            }

        }

        weight = 0;
        while (!stack.isEmpty()) {
            // stack.pop();
            int v = stack.pop();
            weight += v;
            // System.out.println(v);

        }

        totalMass = weight;

        return totalMass;

    }
}
