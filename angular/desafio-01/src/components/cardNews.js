class Cardnews extends HTMLElement{
    constructor(){
        super()

        const shadow = this.attachShadow({mode:'open'});
        shadow.appendChild(this.build())
        shadow.appendChild(this.styles())
    }

    build(){
        const componentRoot = document.createElement('div')
        componentRoot.setAttribute('class', 'card')

        const cardLeft = document.createElement('div')
        cardLeft.setAttribute('class', 'card-left')

        const author = document.createElement('span');
        author.textContent = 'By ' + (this.getAttribute('autor') || 'Anonymous')

        const linkTitle = document.createElement('a')
        linkTitle.textContent = this.getAttribute('title')
        linkTitle.href = this.getAttribute('link-url')

        const newsContent = document.createElement('p')
        newsContent.textContent = this.getAttribute('content')

        cardLeft.appendChild(author)
        cardLeft.appendChild(linkTitle)
        cardLeft.appendChild(newsContent)

        const cardRight = document.createElement('div')
        cardRight.setAttribute('class', 'card-right')

        const newsImage = document.createElement('img')
        newsImage.src = this.getAttribute('image-news')
        newsImage.alt = 'Gatinhos'

        cardRight.appendChild(newsImage)

        componentRoot.appendChild(cardLeft)
        componentRoot.appendChild(cardRight)

        return componentRoot
    }

    styles(){
        const style = document.createElement('style')
        style.textContent= `
        .card {
            display: flex;
            width: 80%;
            justify-content: space-between;
            -webkit-box-shadow: 7px 18px 16px -6px rgba(0, 0, 0, 0.75);
            -moz-box-shadow: 7px 18px 16px -6px rgba(0, 0, 0, 0.75);
            box-shadow: 7px 18px 16px -6px rgba(0, 0, 0, 0.75);
        }
        
        .card-left {
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding-left: 10px;
        }
        
        .card-left>span {
            font-weight: 400;
        }
        
        .card-left>a {
            margin-top: 15px;
            font-size: 25px;
            text-decoration: none;
            color: black;
            font-weight: 600
        }
        
        .card-left>p {
            color: rgb(90, 89, 89);
        }
        `

        return style

    }
}

customElements.define('card-news', Cardnews)