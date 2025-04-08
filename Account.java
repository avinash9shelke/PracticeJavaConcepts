/**
 * @author avinash
 * <p>A sealed class is a class or interface that restricts which other classes or interfaces may extend.</p>
 * 1. final class cannot be extended further.
 * 2. sealed class can only be extended by its permitted subclasses.
 * 3. non-sealed class can be extended by unknown subclasses as well. A sealed class cannot force the sealing behavior to its permitted subclasses.
 * 4. The sealed class and its subclasses, all must be inside the same module.
 * 5.If the permitted classes are written in the same .java file then we can omit the permits keyword.
 */
sealed class Account permits CurrentAccount, SavingAccount, LoanAccount {
    /**
     * If the below code in the same .class file then permits keyword is not required
     *
     * public sealed class Account {}    //Omits 'permits' keyword
     *
     * final class CurrentAccount extends Account {}
     * non-sealed class SavingAccount extends Account {}
     * sealed class LoanAccount extends Account {}   //Omits 'permits' keyword
     *
     * final class HomeloanAccount extends LoanAccount{}
     * final class AutoloanAccount extends LoanAccount{}
     */
}
