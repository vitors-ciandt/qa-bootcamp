export abstract class BaseMock {
  protected getAliasId(alias: string): string {
    return alias.substring(1);
  }
}
