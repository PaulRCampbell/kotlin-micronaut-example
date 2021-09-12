package transactions

import com.example.accounts.Account
import java.math.BigDecimal

data class Transaction (val id: String,
                         val title: String,
                         val description: String,
                         val value: BigDecimal,
                         val account: Account)