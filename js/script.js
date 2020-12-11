const openModalButtons = document.querySelectorAll('[data-modal-target]')
const openModalButtons1 = document.querySelectorAll('[data-modal-target1]')
const openModalButtons2 = document.querySelectorAll('[data-modal-target2]')
const openModalButtons3 = document.querySelectorAll('[data-modal-target3]')
const closeModalButtons = document.querySelectorAll('[data-close-button]')
const overlay = document.getElementById('overlay')

openModalButtons.forEach(button => {
    button.addEventListener('click', () => {
        const modal = document.querySelector(button.dataset.modalTarget)
        openModal(modal)
    })
})


openModalButtons2.forEach(button => {
    button.addEventListener('click', () => {
        const modal2 = document.querySelector(button.dataset.modalTarget)
        openModal2(modal2)
    })
})


overlay.addEventListener('click', () => {
    const modals = document.querySelectorAll('.modal.active')
    modals.forEach(modal => {
        closeModal(modal)
    })
})

closeModalButtons.forEach(button => {
    button.addEventListener('click', () => {
        const modal = button.closest('.modal')
        closeModal(modal)
    })
})

function openModal(modal) {
    if (modal == null) return
    modal.classList.add('active')
    overlay.classList.add('active')
}



function openModal2(modal2) {
    if (modal2 == null) return
    modal2.classList.add('active')
    overlay.classList.add('active')
}


function closeModal(modal) {
    if (modal == null) return
    modal.classList.remove('active')
    overlay.classList.remove('active')
}

function closeModalonsignup(modal) {
    if (modal == null) return
    modal.classList.remove('active')
    overlay.classList.remove('active')
    openModal2(modal2)
}

function closeModalonlogin(modal2) {
    if (modal2 == null) return
    modal2.classList.remove('active')
    overlay.classList.remove('active')
    openModal(modal)

}