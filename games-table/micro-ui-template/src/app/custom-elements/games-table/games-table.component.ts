import { ChangeDetectorRef, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material';
import * as moment from 'moment';
import { Game } from './game';
import { GamesService } from './games.service';

@Component({
  selector: 'app-games-table',
  templateUrl: './games-table.component.html'
})
export class GamesTableComponent implements OnInit {
  // Outputs
  @Output() readonly onMicroUiLoaded: EventEmitter<string> = new EventEmitter();

  // Public variables
  displayedColumns = ['id', 'timestamp', 'card1', 'card2'];
  filterForm: FormGroup;
  games: MatTableDataSource<Game> = new MatTableDataSource<Game>();

  constructor(
    private formBuilder: FormBuilder,
    private gamesService: GamesService
  ) {
    this.filterForm = this.formBuilder.group({
      pastDays: 1
    });
  }

  ngOnInit(): void {
    this.onSubmit();
  }

  onSubmit(): void {
    const pastDays = this.filterForm.value['pastDays'];

    const date = moment(new Date()).add(moment.duration(-pastDays, 'days'));
    this.filter(date.toDate());
  }

  private filter(date: Date): void {
    this.gamesService.findAllAfterTimestamp(date)
      .subscribe((games: Game[]) => {
        console.log('games', games);
        this.games.data = games;
      });
  }
}
