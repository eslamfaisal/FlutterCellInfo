import 'package:cell_info/models/common/common_wtdscdma_parameters.dart';

class WCDMAParameters extends CommonWCDMAParameters {
  int psc;
  int ecio;
  int ecno;

  WCDMAParameters({
    this.psc,
    this.ecio,
    this.ecno,
  });

  WCDMAParameters.fromJson(Map<String, dynamic> map) {
    this.psc = map['psc'];
    this.ecio = map['ecio'];
    this.ecno = map['ecno'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['psc'] = this.psc;
      data['ecio'] = this.ecio;
      data['ecno'] = this.ecno;
      return data;
    }
  }
}