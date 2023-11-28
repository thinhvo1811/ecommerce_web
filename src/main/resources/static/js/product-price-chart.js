const chartBtn = document.querySelector(".product-chart__btn")
const productSelect = document.querySelector(".product-chart__product-list")

chartBtn.onclick = () => {
    getProductByID(productSelect.value,renderChart)
}

const getProductByID = (id,callback) => {
    fetch(`/products/${id}`)
        .then((response) => {
            return response.json();
        })
        .then(callback)
}

const renderChart = (product) => {
    var dates = product.productPrices.map(productPrice => {
        return `${productPrice.price_date_time}`
    })
    var prices = product.productPrices.map(productPrice => {
        return productPrice.price
    })
    chartProduct(dates,prices)
}

const chartProduct = (categories,data) => {
    Highcharts.chart("product-chart__chart", {
        title: {
            text: 'Product Price Chart',
        },
        xAxis: {
            categories: categories
        },
        yAxis: {
            title: {
                text: 'Price (đ)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'đ'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            data: data
        }]
    });
}


