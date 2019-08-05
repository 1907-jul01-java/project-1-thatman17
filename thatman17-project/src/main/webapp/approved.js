let approvals = [];
let approvalsElement = document.querySelector('#approved');

function ListApprovals(approvals) {
    return `<table> 
				<tr>
					<th>Id</th>
                    <th>Username</th>
                    <th>Cost</th>
                    <th>Reason</th>
                </tr>
                ${approvals.map(ListApproval).join('')}
            </table>`;
}

function ListApproval(approval) {
	return `<tr>
				<td>${approval.id}</td>
                <td>${approval.username}</td>
                <td>${approval.cost}</td>
                <td>${approval.picture}</td>
            </tr>`;
}

function updateApprovalsElement() {
    approvalsElement.innerHTML = ListApprovals(approvals);
}

function getApproved() {
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'v1/approve/');
    xhr.onload = function() { 
        approvals = JSON.parse(xhr.responseText); 
        updateApprovalsElement();
    };
    xhr.send();
}

