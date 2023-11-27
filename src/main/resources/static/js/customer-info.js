const headerSearchInput = document.querySelector('.header__search-input')
const headerHistoryList = document.querySelector('.header__search-history-list')


headerHistoryList.onmousedown = (e) => {
    e.preventDefault()
}

const getAllProducts = (keyword, callback) => {
    fetch(`/products-by-keyword/${keyword}`)
        .then((response) => {
            return response.json();
        })
        .then(products => {
            callback(products)
        })
}

const renderSearchInput = (products) => {
    var htmls = products.map(product => {
        return `
            <li class="header__search-history-item">
                <a href="/product-details/${product.product_id}">${product.name}</a>
            </li>
        `
    })

    headerHistoryList.innerHTML = htmls.join('')
}

const handleSearch = () => {
    headerSearchInput.onkeydown = (e) => {
        getAllProducts(e.target.value, renderSearchInput)
    }
}


const start = () => {
    handleSearch();
}

start();