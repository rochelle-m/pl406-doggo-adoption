

<div class="modal" in:fade out:fade>
  <div class="backdrop" on:dblclick={close} />
  <div class="content-wrapper">
    <div class="content">
      <div class="close" on:click={close}>×</div>
      <div class="img-bg">
        <img src="images/dog2.jpg" alt="banner" />
      </div>
      <h2 class="message">Adoption Application</h2>
      <div class="container">

<form class="content">

            <label for="name"><b>Name: </b></label>
            <input type="text" placeholder="Enter name" name="name" required>
            <br>
            <br>
            <label for="phone_number"><b>Phone Number: </b></label>
            <input type="text" placeholder="Phone number" name="phone_number" required>
            <br><br>
            
            <label for="address"><b>Address: </b></label>
            <input type="text" placeholder="Address" name="address" required>
            <br>
            <br>
            <label for="occupation"><b>Occupation: </b></label>
            <input type="text" placeholder="Occupation" name="occupation" required>
            <br>
            <br>


            <label  for="ownpet"><b>Have you previously owned pets? </b></label>
            <input type="radio" name="yes" value="Yes" /> Yes
            <input type="radio" name="no" value="No" /> No
            <br>
            <br>

            <label  for="allergy"><b>Does anyone in the family have known allergy to dogs? </b></label>
            <input type="radio" name="yes" value="Yes" /> Yes
            <input type="radio" name="no" value="No" /> No
            <br>
            <br>


             <label  for="noOfAdults"><b>How many adults are there in your family?(18+)</b></label>
             <input type="number" placeholder="noOfAdults" name="noOfAdults" required>
            <br>
            <br>

            <label  for="noOfChildren"><b>How many children are there in your family? </b></label>
             <input type="number" placeholder="noOfChildren" name="noOfChildren" required>
            <br>
            <br>

            <label  for="household"><b>What type of home do you live in? </b></label><br>
            <input type="radio" name="house" value="House" /> House
            <input type="radio" name="flat" value="Flat" /> Flat
            <input type="radio" name="Bunglow" value="Bunglow" /> Bunglow
            <input type="radio" name="farm house" value="Farm house" /> Farm house
            <br>
            <br>

            <label  for="household"><b>Please describe your household: </b></label><br>
            <input type="radio" name="active" value="Active" /> Active
            <input type="radio" name="noisy" value="Noisy" /> Noisy
            <input type="radio" name="quiet" value="Quiet" /> Quiet
            <input type="radio" name="average" value="Average" /> Average
            <br>
            <br>


             <label  for="whytoadopt"><b>Why do you want to adopt this pet? </b></label>
              <input type="checkbox" name="companionForSelf" value="companionForSelf" /> Companion For Self
              <input type="checkbox" name="companionForChild" value="companionForChild" /> Companion For Child
              <input type="checkbox" name="companionForOtherDog" value="companionForOtherDog" /> Companion For Other Dog
              <input type="checkbox" name="security" value="Security" /> Security
              <input type="checkbox" name="housePet" value="housePet" /> House Pet

             <br>
            <br>

            <label  for="time"><b>Do you have enough time to provide adwquate love and affection? </b></label>
            <input type="radio" name="yes" value="Yes" /> Yes
            <input type="radio" name="no" value="No" /> No
            <br>
            <br>

            <label  for="ownpet"><b>Is everyone in agreement with the decision to adopt a dog? </b></label>
            <input type="radio" name="yes" value="Yes" /> Yes
            <input type="radio" name="no" value="No" /> No
            <br>
            <br>


             <button type="submit" class="">Apply For Adoption</button>
            <br><br><br>
          
  
</form>
       
      </div>
    </div>
  </div>
</div>

<style>
  div.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  div.backdrop {
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(50, 50, 50, 0.5);
  }

  div.content-wrapper {
    z-index: 10;
    width: 40vw;
    border-radius: 0.3rem;
    background-color: white;
    overflow: hidden;
  }

  div.content {
    max-height: 95vh;
    overflow: auto;
  }

  form .form-group {
    text-align: left;
  }

  form {
    margin-top: -20px;
  }

  h2.message {
    position: relative;
    z-index: 10;
    top: -15vh;
    font-size: 5vmin;
    margin: auto;
    width: fit-content;
    text-align: center;
    display: block;
    padding-bottom: 10px;
    text-transform: uppercase;
    border-bottom: 1px solid rgb(255, 254, 254);
    color: white;
  }

  div.close {
    position: relative;
    left: -1em;
    top: 10px;
    cursor: pointer;
    font-size: 2vw;
    margin-bottom: -50px;
    color: white;
    z-index: 1033;
  }

  div.img-bg {
    width: inherit;
    height: 28vh;
    background: gray;
  }

  img {
    filter: brightness(40%);
    width: 100%;
    height: 28vh;
  }

  div > span {
    cursor: pointer;
  }

   @media (max-width: 792px) {  
    div.content-wrapper {
      width: 55vw;
    }
  }


</style>
