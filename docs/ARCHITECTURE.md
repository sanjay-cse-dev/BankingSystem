Main -> ConsoleUI -> BankingServices -> BankingServiceImpl -> AccountRepository -> Account

## Responsibilities

### Main
Application start karta hai aur dependencies create karta hai.

### ConsoleUI
User se input leta hai aur result display karta hai.
Business logic yahan nahi hona chahiye.

### BankingServices
Banking operations ka contract define karta hai.

### BankingServiceImpl
Banking operations coordinate karta hai.

### AccountRepository
Accounts ko store aur retrieve karta hai.

### Account
Account ki state aur account-related behavior manage karta hai.