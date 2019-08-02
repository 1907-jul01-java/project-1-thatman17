let transactions = [];
let transactionsElement = document.querySelector('#transactions');

function ListTransactions(transactions) {
    return `<table>
                <tr>
                    <th>Username</th>
                    <th>Cost</th>
                    <th>Picture</th>
                </tr>
                ${transactions.map(ListTransaction).join('')}
            </table>`;
}

function ListTransaction(transaction) {
    return `<tr>
                <td>${transaction.username}</td>
                <td>${transaction.cost}</td>
                <td>${transaction.picture}</td>
            </tr>`;
}

function updateTransactionsElement() {
    transactionsElement.innerHTML = ListTransactions(transactions);
}

function getTransactions() {
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'v1/transactions/');
    xhr.onload = function() { 
        transactions = JSON.parse(xhr.responseText); 
        updateTransactionsElement();
    };
    xhr.send();
}

