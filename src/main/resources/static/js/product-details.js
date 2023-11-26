const headerSearchInput = document.querySelector('.header__search-input')
const headerHistoryList = document.querySelector('.header__search-history-list')
const productImgItem = document.querySelectorAll('.product-detail__img-list--item')
const productImgMain = document.querySelector('.product-detail__img-main')
const modal = document.querySelector('.modal')
const modalOverlay = document.querySelector('.modal__overlay')
const register = document.querySelector('.navbar-item--register')
const login = document.querySelector('.navbar-item--login')
const registerForm = document.querySelector('.auth-form--register')
const loginForm = document.querySelector('.auth-form--login')
const backRegisterBtn = document.querySelector('.auth-form--register .btn.auth-form__controls-back')
const backLoginBtn = document.querySelector('.auth-form--login .btn.auth-form__controls-back')
const switchRegisterBtn = document.querySelector('.auth-form--register .auth-form__switch-btn')
const switchLoginBtn = document.querySelector('.auth-form--login .auth-form__switch-btn')

headerHistoryList.onmousedown = (e) => {
    e.preventDefault()
}

modalOverlay.onclick = () => {
    modal.style.display = "none"
    registerForm.style.display = "none"
    loginForm.style.display = "none"
}

register.onclick = () => {
    modal.style.display = "flex"
    registerForm.style.display = "block"
}

login.onclick = () => {
    modal.style.display = "flex"
    loginForm.style.display = "block"
}

backRegisterBtn.onclick = () => {
    registerForm.style.display = "none"
    modal.style.display = "none"
}

backLoginBtn.onclick = () => {
    loginForm.style.display = "none"
    modal.style.display = "none"
}

switchRegisterBtn.onclick = () => {
    registerForm.style.display = "none"
    loginForm.style.display = "block"
}

switchLoginBtn.onclick = () => {
    loginForm.style.display = "none"
    registerForm.style.display = "block"
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