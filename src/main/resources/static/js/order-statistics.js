const statictisByDate = document.querySelector(".order-statictis__by-date")
const statictisByPeriod = document.querySelector(".order-statictis__by-period")
const statictisByEmployeeAndPeriod = document.querySelector(".order-statictis__by-employee-and-period")
const selectEmployeeForm = document.querySelector(".order-statictis__select-employee")
const fromdateForm = document.querySelector(".order-statictis__select-fromdate")
const todateForm = document.querySelector(".order-statictis__select-todate")
const fromdateLabel = document.querySelector(".fromdate-label")
const statisticBtn = document.querySelector(".statistic__btn")
const selectInputLabel = document.querySelector(".select-input__label")
const employeeSelect = document.querySelector(".order-statictis__employee-list")
const fromdateInput = document.querySelector(".order-statictis__fromdate-input")
const todateInput = document.querySelector(".order-statictis__todate-input")

statictisByDate.onclick = (e) => {
    e.preventDefault()
    fromdateForm.style.display = "block"
    fromdateLabel.textContent = "Ngày"
    selectInputLabel.textContent = "Theo ngày"
    todateForm.style.display = "none"
    selectEmployeeForm.style.display = "none"
    statisticBtn.style.display = "block"
}

statictisByPeriod.onclick = (e) => {
    e.preventDefault()
    fromdateForm.style.display = "block"
    todateForm.style.display = "block"
    selectEmployeeForm.style.display = "none"
    fromdateLabel.textContent = "Từ ngày"
    selectInputLabel.textContent = "Theo khoảng thời gian"
    statisticBtn.style.display = "block"
}

statictisByEmployeeAndPeriod.onclick = (e) => {
    e.preventDefault()
    fromdateForm.style.display = "block"
    todateForm.style.display = "block"
    selectEmployeeForm.style.display = "block"
    fromdateLabel.textContent = "Từ ngày"
    selectInputLabel.textContent = "Theo nhân viên"
    statisticBtn.style.display = "block"
}


const getOrdersByDate = (date,callback) => {
    fetch(`/orders-by-date?date=${date}`)
        .then((response) => {
            return response.json();
        })
        .then(callback)
}

const getOrdersByPeriod = (fromdate,todate,callback) => {
    fetch(`/orders-by-period?fromDate=${fromdate}&toDate=${todate}`)
        .then((response) => {
            return response.json();
        })
        .then(callback)
}

const getOrdersByEmployeeAndPeriod = (employeeID,fromdate,todate,callback) => {
    fetch(`/orders-employee-and-by-period?empId=${employeeID}&fromDate=${fromdate}&toDate=${todate}`)
        .then((response) => {
            return response.json();
        })
        .then(callback)
}

const renderOrders = (orders) => {
    const orderList = document.querySelector(".order-statictis__order-list")
    const formatCash = (str) => {
        return str.split('').reverse().reduce((prev, next, index) => {
            return ((index % 3) ? next : (next + '.')) + prev
        })
    }
    var htmls = orders.map(order => {
        return `
            <tr>
                <th scope="row">${order.order_id}</th>
                <td>${order.orderDate}</td>
                <td>${formatCash(String(order.orderDetails.reduce((acc,cur)=>acc+cur.price,0)))}đ</td>
            </tr>
        `
    })
    var html = `
            <table class="table table-striped table-hover">
                <thead class="fs-3">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody class="fs-4">
                    ${htmls.join('')}
                    <tr>
                        <th scope="row">Total</th>
                        <td></td>
                        <td>${formatCash(String(orders.reduce((acc,cur)=>acc+cur.orderDetails.reduce((acc,cur)=>acc+cur.price,0),0)))}đ</td>
                  </tr>
                </tbody>
            </table>
    `
    orderList.innerHTML = html
}

statisticBtn.onclick = () => {
    if(selectInputLabel.textContent == "Theo ngày"){
        const date = fromdateInput.value

        if(date){
            getOrdersByDate(date, renderOrders)
        }
        else{
            alert("Vui lòng chọn ngày")
        }
    }
    else if(selectInputLabel.textContent == "Theo khoảng thời gian"){
        const fromdate = fromdateInput.value
        const todate = todateInput.value

        if(fromdate && todate){
            getOrdersByPeriod(fromdate, todate, renderOrders)
        }
        else if(!fromdate){
            alert("Vui lòng chọn từ ngày nào")
        }
        else if(!todate){
            alert("Vui lòng chọn đến ngày nào")
        }
    }
    else if(selectInputLabel.textContent == "Theo nhân viên"){
        const fromdate = fromdateInput.value
        const todate = todateInput.value
        const employeeID = employeeSelect.value

        if(employeeID && fromdate && todate){
            getOrdersByEmployeeAndPeriod(employeeID, fromdate, todate, renderOrders)
        }
        else if(!fromdate){
            alert("Vui lòng chọn từ ngày nào")
        }
        else if(!todate){
            alert("Vui lòng chọn đến ngày nào")
        }
    }
}
;