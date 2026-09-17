const payButton = document.getElementById("payButton");

payButton.addEventListener("click", function () {

    const amount = document.getElementById("amount").value;
    const accountNumber =
        document.getElementById("accountNumber").value;

    const message = document.getElementById("message");

    if (amount <= 0) {
        message.textContent = "Enter a valid amount.";
        return;
    }

    if (accountNumber === "") {
        message.textContent = "Enter account number.";
        return;
    }

    message.textContent =
        "Payment successful. Amount: ₹" + amount;
});