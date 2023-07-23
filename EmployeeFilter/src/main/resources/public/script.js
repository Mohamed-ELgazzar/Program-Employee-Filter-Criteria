// Wait for the DOM content to be loaded
document.addEventListener("DOMContentLoaded", function () {
  // Get a reference to the search form
  const searchForm = document.getElementById("searchForm");

  // Get a reference to the employee table body
  const tableBody = document.querySelector("#employeeTable tbody");

  // Add a submit event listener to the search form
  searchForm.addEventListener("submit", function (event) {
    event.preventDefault();

    // Clear the table body before adding new search results
    tableBody.innerHTML = "";

    // Get the search criteria from the form inputs
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

    // Create an object with the search criteria
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

    // Send the search criteria as a POST request to the backend API
    fetch("/employees/search", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(searchCriteria),
    })
      .then((response) => response.json())
      .then((data) => {
        // Populate the table with the search results
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
