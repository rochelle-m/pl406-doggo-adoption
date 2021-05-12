export default async function post(url, user) {
    const response = await fetch(url, {
      method: 'POST', 
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
        'Accept': 'application/json'
      },
      referrerPolicy: 'no-referrer',
      body: JSON.stringify(user) 
    })
    
    return response
}