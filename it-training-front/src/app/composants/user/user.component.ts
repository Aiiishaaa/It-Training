import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Session } from 'src/app/interfaces/session';
import { User } from 'src/app/interfaces/user';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from '../../services/user.service';
 
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  board: string = "";
  errorMessage: string = "";
  inscriptions: Session[] = [];
  // userName: string = "";
  // user: User = {};
  // userId: number = 0;

  constructor(private userService: UserService,
    private sessionServ: SessionService,
    private token: TokenStorageService) { }
 
  ngOnInit() {

    // this.userName = this.token.getUsername();
    // this.userService.getOneUserByUsername(this.userName).subscribe( res => {
    //   this.user = res;
    //   this.userId = this.user.id ?? 0;
    //   this.recupInscriptionsClient(this.userId);
    // });
    

    this.userService.getUserBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }

  recupInscriptionsClient(id: number) {
    this.sessionServ.getAllSessionsByUser(id).subscribe( res => {
      this.inscriptions = res;
    })
  }
  
}

// import { Component, OnInit, Type } from '@angular/core';
// import { User } from 'src/app/interfaces/user';
// import { UserService } from '../../services/user.service';
// import  'c:/Users/Sony/eclipse-workspace/It-Training/it-training-front/src/assets/js/script.js';

// @Component({
//   selector: 'app-user',
//   templateUrl: './user.component.html',
//   styleUrls: ['./user.component.css']
// })
// export class UserComponent implements OnInit {
//   users: User[] = [];
//   index : number = 0;
//   user: User = {};

//   constructor(private userService: UserService) { }
 
//   ngOnInit() {
//     this.initUser();
//   }

//   initUser() {
//     this.user = {
//       id: 0,
//       name: '',
//       email: '',
//       password: ''
//     };
//   }
//   getUserByUsername(username: string) {
//     this.userService.getOneUserByUsername(username).subscribe(
//       (user: User) => {
//         this.user = user;
//       }
//     );
//   }

//   selectUser(user: User, index: number) {
//     this.user = user;
//     this.index = index;
//   }

//   // getUserById() {       
//   //   this['httpProvider'].getUserById(this.user).subscribe((data : any) => {      
//   //     if (data != null && data.body != null) {
//   //       var resultData = data.body;
//   //       if (resultData) {
//   //         this.user = resultData;
//   //       }
//   //     }
//   //   },
//   //   (error :any)=> { }); 
//   // }
// }
//     // this.userService.getUserBoard().subscribe(
//     //   data => {
//     //     this.board = data;
//     //   },
//     //   error => {
//     //     this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
//     //   }
//     // );`