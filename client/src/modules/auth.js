const API_URL = 'http://localhost:5001/api/auth/';
import { authorize, create, put } from "./request"
import { user } from "../stores/user";

let logOn = {
  login: {
    title: "Login",
    banner: "/images/dog13.jpg",
    alt: "Sign Up",
    request: async (newUser) => {
        const response  = await create(
          API_URL + "signin",
          {
            username: newUser.username,
            password: newUser.password
          }
        )
        const userData = await response.json()
        if(userData.token){
          localStorage.setItem('user', JSON.stringify({...userData, isLoggedIn: true}));
          user.add({...userData, isLoggedIn: true})
          return true
        }
        return false
    }
  },
  signup: {
    title: "Sign Up",
    banner: "/images/dog2.jpg",
    alt: "Login",
    request: async (newUser, vrole = null) => {
      const response = await create(
        API_URL + "signup",
        {
          username: newUser.username,
          password: newUser.password,
          email: newUser.email,
          roles: newUser.roles || ["user"],
          volunteerRole: vrole
        }
      )
      const userData = await response.json()
      if(userData.token){
        localStorage.setItem('user', JSON.stringify({...userData, isLoggedIn: true}));
        user.add({...userData, isLoggedIn: true})
        return true
      }
      return false
    }
  },
};

let logout = async () => {
  let { type, token } = JSON.parse(localStorage.getItem('user'))
  await authorize(API_URL + "logout", type + " " + token)
  localStorage.removeItem('user')
  user.reset() 
}

let update = async (role) => {
  console.log(role, "f")
  const { type, token, id } = JSON.parse(localStorage.getItem('user'))
  const response = await put(`${API_URL}update/${id}/${role}`, type + " " + token)
  console.log(response)
}

export {logOn, logout, update};
