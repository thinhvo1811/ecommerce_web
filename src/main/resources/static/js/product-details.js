const headerSearchInput = document.querySelector('.header__search-input')
const headerHistoryList = document.querySelector('.header__search-history-list')
const productImgItem = document.querySelectorAll('.product-detail__img-list--item')
const productImgMain = document.querySelector('.product-detail__img-main')

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
                <a  href="/product-details/${product.product_id}">${product.name}</a>
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

const handleClickImg = (e) => {
    for(var i = 0; i < productImgItem.length; i++){
        productImgItem[i].onclick = (e) => {
            productImgMain.style.backgroundImage = e.target.style.backgroundImage;
        }
    }
}

const start = () => {
    handleSearch();
    handleClickImg();
}

start();