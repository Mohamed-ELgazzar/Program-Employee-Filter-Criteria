document.addEventListener("DOMContentLoaded", function () {
  const searchForm = document.getElementById("searchForm");

  const tableBody = document.querySelector("#employeeTable tbody");

  searchForm.addEventListener("submit", function (event) {
    event.preventDefault();

    tableBody.innerHTML = "";

    const code = document.getElementById("ecode").value.trim();
    const name = document.getElementById("ename").value.trim();
    const birthDate = document.getElementById("birth").value.trim();
    const birthCity = document.getElementById("birthcity").value;
    const employeeId = document.getElementById("eid").value.trim();
    const departmentName = document.getElementById("department").value;
    const jobTitle = document.getElementById("job").value.trim();
    const directManager = document.getElementById("manager").value.trim();
    const contractType = document.getElementById("contract").value;
    const status = document.getElementById("status").value;

    const searchCriteria = {
      code: code || null,
      name: name || null,
      birthDate: birthDate || null,
      birthCity: birthCity === "Select" ? null : birthCity,
      employeeId: employeeId || null,
      departmentName: departmentName === "Select" ? null : departmentName,
      jobTitle: jobTitle || null,
      directManager: directManager || null,
      contractType: contractType === "Select" ? null : contractType,
      status: status === "Select" ? null : status === "true",
    };

    fetch("/employees/search", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(searchCriteria),
    })
      .then((response) => response.json())
      .then((data) => {
        data.forEach((employee) => {
          const row = tableBody.insertRow();
          row.innerHTML = `
            <td><ion-icon class="icon" name="options-outline"></ion-icon></td>
            <td><ion-icon class="icon" name="pencil-outline"></ion-icon></td>
            <td>${employee.code}</td>
            <td>${employee.name}</td>
            <td>${employee.birthDate}</td>
            <td>${employee.birthCity}</td>
            <td>${employee.employeeId}</td>
            <td>${employee.departmentName}</td>
            <td>${employee.jobTitle}</td>
            <td>${employee.directManager}</td>
            <td>${employee.contractType}</td>
            <td>
              <ion-icon class="icon right" name="checkmark-outline"></ion-icon>
            </td>
          `;
        });
      })
      .catch((error) => {
        console.error("Error fetching search results:", error);
      });
  });
});
