async function create(url, user) {
    return fetch(url, {
      method: 'POST', 
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Accept': 'application/json'
      },
      referrerPolicy: 'no-referrer',
      body: JSON.stringify(user) 
    })
}

async function authorize(url, token) {
    return fetch(url, {
      method: 'POST', 
      headers: {
        'Authorization': token
      }
    })
}

async function put (url, token) {
    return fetch(url, {
      method: 'PUT', 
      headers: {
        'Authorization': token
      },
      referrerPolicy: 'no-referrer'
    })
}

export { create, authorize, put };