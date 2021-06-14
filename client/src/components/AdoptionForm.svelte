<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Adopt";
  let message = "Adoption Form";
  let imgSrc = "images/event2.jpg";
</script>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />
  <div class="d-flex flex-wrap justify-content-around spacing">
    <div class="container">
      <form class="content">
        <label for="name"><b>Name: </b></label>
        <input type="text" placeholder="Enter name" name="name" required />
        <br />
        <br />
        <label for="phone_number"><b>Phone Number: </b></label>
        <input
          type="text"
          placeholder="Phone number"
          name="phone_number"
          required />
        <br /><br />

        <label for="address"><b>Address: </b></label>
        <input type="text" placeholder="Address" name="address" required />
        <br />
        <br />
        <label for="occupation"><b>Occupation: </b></label>
        <input
          type="text"
          placeholder="Occupation"
          name="occupation"
          required />
        <br />
        <br />

        <label for="ownpet"><b>Have you previously owned pets? </b></label>
        <input type="radio" name="ownpet" value="Yes" />
        Yes
        <input type="radio" name="ownpet" value="No" />
        No
        <br />
        <br />

        <label for="allergy"><b>Does anyone in the family have known allergy to
            dogs?
          </b></label>
        <input type="radio" name="allergy" value="Yes" />
        Yes
        <input type="radio" name="allergy" value="No" />
        No
        <br />
        <br />

        <label for="noOfAdults"><b>How many adults are there in your
            family?(18+)</b></label>
        <input
          type="number"
          placeholder="noOfAdults"
          name="noOfAdults"
          required />
        <br />
        <br />

        <label for="noOfChildren"><b>How many children are there in your family?
          </b></label>
        <input
          type="number"
          placeholder="noOfChildren"
          name="noOfChildren"
          required />
        <br />
        <br />

        <label for="household"><b>What type of home do you live in?
          </b></label><br />
        <input type="radio" name="home" value="House" />
        House
        <input type="radio" name="home" value="Flat" />
        Flat
        <input type="radio" name="home" value="Bunglow" />
        Bunglow
        <input type="radio" name="home" value="Farm house" />
        Farm house
        <br />
        <br />

        <label for="household"><b>Please describe your household:
          </b></label><br />
        <input type="radio" name="household" value="Active" />
        Active
        <input type="radio" name="household" value="Noisy" />
        Noisy
        <input type="radio" name="household" value="Quiet" />
        Quiet
        <input type="radio" name="household" value="Average" />
        Average
        <br />
        <br />

        <label for="whytoadopt"><b>Why do you want to adopt this pet?
          </b></label>
        <input
          type="checkbox"
          name="companionForSelf"
          value="companionForSelf" />
        Companion For Self
        <input
          type="checkbox"
          name="companionForChild"
          value="companionForChild" />
        Companion For Child
        <input
          type="checkbox"
          name="companionForOtherDog"
          value="companionForOtherDog" />
        Companion For Other Dog
        <input type="checkbox" name="security" value="Security" />
        Security
        <input type="checkbox" name="housePet" value="housePet" />
        House Pet

        <br />
        <br />

        <label for="time"><b>Do you have enough time to provide adwquate love
            and affection?
          </b></label>
        <input type="radio" name="time" value="Yes" />
        Yes
        <input type="radio" name="time" value="No" />
        No
        <br />
        <br />

        <label for="agreement"><b>Is everyone in agreement with the decision to
            adopt a dog?
          </b></label>
        <input type="radio" name="agreement" value="Yes" />
        Yes
        <input type="radio" name="agreement" value="No" />
        No
        <br />
        <br />

        <button type="submit" class="">Apply For Adoption</button>
        <br /><br /><br />
      </form>
    </div>
  </div>
</div>
